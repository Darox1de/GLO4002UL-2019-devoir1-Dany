package Classes;

import java.util.LinkedList;

public class CommunityCenter {
    public TriageType serviceType;
    public LinkedList<String> nurseQueue = new LinkedList<String>();

    public CommunityCenter(TriageType serviceType) {
        this.serviceType = serviceType;
    }

    public void triagePatient(String name, int gravity) {
        if(gravity < 2){
            return;
        }
        if(gravity > 5 && serviceType == TriageType.GRAVITY){
            nurseQueue.add(0, name);
        } else if(serviceType == TriageType.FIFO){
            nurseQueue.add(name);
        }
    }
}
