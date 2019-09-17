package Classes;
import java.util.LinkedList;
import java.lang.String;

abstract class CommunityCenter {
    public LinkedList<String> nurseQueue = new LinkedList<String>();
    abstract public void triagePatient(String name, int gravity);
}
class CommunityCenterGravity extends CommunityCenter {
    public void triagePatient(String name, int gravity) {
        if(gravity < 2) {
            return;
        }
        nurseQueue.add(0, name);
    }
}
class CommunityCenterFifo extends CommunityCenter {
    public void triagePatient(String name, int gravity) {
        if(gravity < 2) {
            return;
        }
        nurseQueue.add(name);
    }
}