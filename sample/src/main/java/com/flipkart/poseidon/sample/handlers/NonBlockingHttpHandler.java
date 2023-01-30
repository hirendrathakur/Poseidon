package com.flipkart.poseidon.sample.handlers;

import com.flipkart.phantom.task.impl.AsyncHystrixTaskHandler;
import com.flipkart.phantom.task.spi.Decoder;
import com.flipkart.phantom.task.spi.TaskContext;
import com.flipkart.phantom.task.spi.TaskRequestWrapper;
import com.flipkart.phantom.task.spi.TaskResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class NonBlockingHttpHandler extends AsyncHystrixTaskHandler {

    public String poolName;
    public String host;
    public String port;
    public String connectionTimeout;
    public String operationTimeout;
    public String timeToLiveInSecs;
    public final String commandPrefix = "HttpRequest";
//    private HttpClient httpClient;

    @Override
    public void init(TaskContext taskContext) throws Exception {
//        httpClient = HttpClient.newBuilder()
//                .connectTimeout(Duration.ofSeconds(120))
//                .executor(Executors.newFixedThreadPool(2))
//                .build();
    }

    @Override
    public <T, S> CompletableFuture<TaskResult<T>> executeAsync(TaskContext taskContext, String s, Map<String, Object> map, S s1) throws RuntimeException {
        return null;
    }

    @Override
    public <T, S> CompletableFuture<TaskResult<T>> executeAsync(TaskContext taskContext, String s, TaskRequestWrapper<S> taskRequestWrapper, Decoder<T> decoder) throws RuntimeException {

        Map<String, Object> params = taskRequestWrapper.getParams();
        byte[] data = (byte[]) taskRequestWrapper.getData();

//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .GET()
//                .timeout(Duration.ofSeconds(1))
////                .uri(new URI(String.format("http://10.24.5.160/v2/get-exposure-meta?abTrackingId=%s", getEncodedString("STG|7FMT27Yhj2XS9SeNKbsqA0|7f3842d9|h"))))
//                .build();
//        CompletableFuture<HttpResponse<String>> cf = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
//        cf.whenComplete(new BiConsumer<HttpResponse<String>, Throwable>() {
//            @Override
//            public void accept(HttpResponse<String> stringHttpResponse, Throwable throwable) {
//                System.out.println(stringHttpResponse.body());
//            }
//        });
        return new CompletableFuture<>();
    }

//    private static String getEncodedString(String s) {
//        return URLEncoder.encode(s, StandardCharsets.UTF_8);
//    }

    @Override
    public String[] getCommands() {
        return new String[]{poolName + commandPrefix};
    }

    @Override
    public String getName() {
        return poolName + "Http";
    }

    @Override
    public void shutdown(TaskContext taskContext) throws Exception {

    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setConnectionTimeout(String connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setOperationTimeout(String operationTimeout) {
        this.operationTimeout = operationTimeout;
    }

    public void setTimeToLiveInSecs(String timeToLiveInSecs) {
        this.timeToLiveInSecs = timeToLiveInSecs;
    }
}
