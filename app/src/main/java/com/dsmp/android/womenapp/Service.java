package com.dsmp.android.womenapp;

/**
 * Created by vipul on 2/20/2018.
 */

public class Service {

    private String id;
    private String serviceName;
    private String serviceState;
    private String serviceMinAge;
    private String serviceMaxAge;
    private String serviceCaste;

    public Service(String id, String serviceName, String serviceState, String serviceMinAge, String serviceMaxAge, String serviceCaste) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceState = serviceState;
        this.serviceMinAge = serviceMinAge;
        this.serviceMaxAge = serviceMaxAge;
        this.serviceCaste = serviceCaste;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }


    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName) {

        this.serviceName = serviceName;
    }

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getServiceMinAge() {
        return serviceMinAge;
    }

    public void setServiceMinAge(String serviceMinAge) {
        this.serviceMinAge = serviceMinAge;
    }

    public String getServiceMaxAge() {
        return serviceMaxAge;
    }

    public void setServiceMaxAge(String serviceMaxAge) {
        this.serviceMaxAge = serviceMaxAge;
    }

    public String getServiceCaste() {
        return serviceCaste;
    }

    public void setServiceCaste(String serviceCaste) {

        this.serviceCaste = serviceCaste;
    }
}

