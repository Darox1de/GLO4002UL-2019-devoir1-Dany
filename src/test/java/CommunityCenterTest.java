package Classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.engine.*;
import java.util.LinkedList;

public class CommunityCenterTest {

    public CommunityCenter communityCenterFifo = new CommunityCenterFifo();
    public CommunityCenter communityCenterGravity = new CommunityCenterGravity();

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheNurseWaitingListWithGravityPriority() {
        communityCenterGravity.triagePatient("Bob", 2);
        communityCenterGravity.triagePatient("Patrick", 20);
        Assertions.assertEquals("Patrick", communityCenterGravity.nurseQueue.get(0));
        Assertions.assertEquals("Bob", communityCenterGravity.nurseQueue.get(1));
    }

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheNurseWaitingListWithFIFO() {
        communityCenterFifo.triagePatient("Bob", 2);
        communityCenterFifo.triagePatient("Patrick", 20);
        Assertions.assertEquals("Bob", communityCenterFifo.nurseQueue.get(0));
        Assertions.assertEquals("Patrick", communityCenterFifo.nurseQueue.get(1));
    }
}