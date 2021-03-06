package cn.lechange.happor;

import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import cn.lechange.happor.annotation.Controller;
import cn.lechange.happor.annotation.UriSection;
import cn.lechange.happor.context.HapporAutomaticContext;
import cn.lechange.happor.controller.HttpNormalHandler;

@Controller(method="GET", uriPattern="^/anno/(\\w+)")
public class TestAnnotation extends HttpNormalHandler {
	
	@UriSection(1)
	private String name;

	@Override
	protected void handle(FullHttpRequest request, FullHttpResponse response) {
		// TODO Auto-generated method stub
		String words = "hello " + name;
		response.content().writeBytes(words.getBytes());
		response.headers().set("Content-Type", "text/plain");
		response.headers().set("Content-Length", response.content().readableBytes());
	}

	@Override
	protected void atlast() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HapporAutomaticContext context = new HapporAutomaticContext();
		context.addFilters(new String[] {"incoming"});
		context.getServer().setPort(9080);
		context.runServer();
	}

}
