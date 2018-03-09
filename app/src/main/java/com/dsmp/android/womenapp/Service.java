package com.dsmp.android.womenapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vipul on 2/20/2018.
 */

public class Service implements Parcelable {

    private String id;
    private String serviceName;
    private String serviceInfo;
    private String serviceState;
    private String serviceMinAge;
    private String serviceMaxAge;
    private String serviceCaste;

    public Service(String id, String serviceName,String serviceinfo, String serviceState, String serviceMinAge, String serviceMaxAge, String serviceCaste) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceInfo= serviceinfo;
        this.serviceState = serviceState;
        this.serviceMinAge = serviceMinAge;
        this.serviceMaxAge = serviceMaxAge;
        this.serviceCaste = serviceCaste;
    }

    public Service() {


    }

    private Service(Parcel in){

        id=in.readString();
        serviceName=in.readString();
        serviceState=in.readString();
        serviceInfo=in.readString();
        serviceMinAge=in.readString();
        serviceMaxAge=in.readString();
        serviceCaste=in.readString();


    }
    public String getServiceInfo() {
        return serviceInfo;
    }


    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

            parcel.writeString(id);
            parcel.writeString(serviceName);
            parcel.writeString(serviceCaste);
            parcel.writeString(serviceMaxAge);
            parcel.writeString(serviceMinAge);
            parcel.writeString(serviceState);
            parcel.writeString(serviceInfo);
    }

    public static final Parcelable.Creator<Service> CREATOR = new Parcelable.Creator<Service>(){

        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        public Service[] newArray(int size) {
            return new Service[size];

        }



    };
}

