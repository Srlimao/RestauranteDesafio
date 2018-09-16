package server;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import org.apache.http.ConnectionClosedException;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.bootstrap.HttpServer;
import org.apache.http.impl.bootstrap.ServerBootstrap;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.ssl.SSLContexts;



public class HttpFileServer {
	HttpServer server ;
	
	public HttpFileServer(){
		
	}
	
    public static void Start() throws Exception {
        int port = 2222;
        
        SSLContext sslContext = null;
        if (port == 8443) {
            // Initialize SSL context
            URL url = HttpFileServer.class.getResource("/my.keystore");
            if (url == null) {
                System.out.println("Keystore not found");
                System.exit(1);
            }
            sslContext = SSLContexts.custom()
                    .loadKeyMaterial(url, "secret".toCharArray(), "secret".toCharArray())
                    .build();
        }

        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(15000)
                .setTcpNoDelay(true)
                .build();

        HttpServer server = ServerBootstrap.bootstrap()
                .setListenerPort(port)
                .setServerInfo("Test/1.1")
                .setSocketConfig(socketConfig)
                .setSslContext(sslContext)
                .setExceptionLogger(new StdErrorExceptionLogger())
                .registerHandler("*", new HttpFileHandler())
                .create();

        server.start();/*
        server.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);*/
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.shutdown(1, TimeUnit.SECONDS);
            }
        });
        
    }
    
    public void Stop() throws InterruptedException {
    	
    	server.shutdown(5, TimeUnit.SECONDS);
    	/*
    	Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.shutdown(5, TimeUnit.SECONDS);
            }
        });*/
    }

    static class StdErrorExceptionLogger implements ExceptionLogger {

        @Override
        public void log(final Exception ex) {
            if (ex instanceof SocketTimeoutException) {
                //System.err.println("Connection timed out");
            } else if (ex instanceof ConnectionClosedException) {
                //System.err.println(ex.getMessage());
            } else {
                //ex.printStackTrace();
            }
        }

    }

    static class HttpFileHandler implements HttpRequestHandler  {
	
        public void handle(
                final HttpRequest request,
                final HttpResponse response,
                final HttpContext context) throws HttpException, IOException {

              String target = request.getRequestLine().getUri();
              TrataRequest.TrataRequest(target);
              StringEntity entity = new StringEntity("TESTE");
        	  response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
        	  response.setEntity(entity);
              
         } 
     }
}


