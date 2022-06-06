package com.thelion.thegeoptapp.api;

public class ServiceProvider<S> implements sProvider<S> {
    private S service;
    private GeoPTServiceGenerator geoPTServiceGenerator;

    public ServiceProvider(Class<S> serviceClass){
        service = (S) GeoPTServiceGenerator.createService(serviceClass);
    }

    @Override
    public S provide() {
        return service;
    }
}
