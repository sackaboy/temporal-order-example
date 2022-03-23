package org.temporal.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkflowOrderStatus {
    public static List<Status> lstStatus = new ArrayList<>();

    public WorkflowOrderStatus(){
        initData();
    }

    private void initData(){
        lstStatus.add(new Status(1,"Waiting Confirm"));
        lstStatus.add(new Status(2,"Delivering"));
        lstStatus.add(new Status(3,"Success Delivered"));
        lstStatus.add(new Status(4,"Received"));
    }

    public WorkflowOrderStatus(List<Status> lstStatus) {
        WorkflowOrderStatus.lstStatus = lstStatus;
    }

    public List<Status> getLstStatus() {
        return WorkflowOrderStatus.lstStatus;
    }

    public void setLstStatus(List<Status> lstStatus) {
        WorkflowOrderStatus.lstStatus = lstStatus;
    }

    public static Status getStatusByID(int ID){
        List<Status> tmp = WorkflowOrderStatus.lstStatus
                .stream()
                .filter(item -> item.getId() == ID)
                .collect(Collectors.toList());
        return tmp.size() > 0 ? tmp.get(0) : null;
    }

    public String getStatusNameByID(int ID){
        Status status = this.getStatusByID(ID);
       return this.getStatusByID(ID) != null ? status.getName() : null;
    }
}