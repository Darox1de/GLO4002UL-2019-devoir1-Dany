import Classes.Clinic;
import Classes.CommunityCenter;
import Classes.TriageType;
import Classes.VisibleSymptom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommunityCenterTest {
    public CommunityCenter communityCenter1 = new CommunityCenter(TriageType.GRAVITY);
    public CommunityCenter communityCenter2 = new CommunityCenter(TriageType.FIFO);

    @Test
    public void communityCenterQueueInstanciation() {
        Assertions.assertEquals(0, communityCenter1.nurseQueue.size());
    }
    @Test
    public void clinicQueueTypes() {
        Assertions.assertEquals(TriageType.GRAVITY, communityCenter1.serviceType);
        Assertions.assertEquals(TriageType.FIFO, communityCenter2.serviceType);
    }
    @Test
    public void triagePatientGravityOver5firstInLine() {
        communityCenter1.triagePatient("Bob", 2);
        communityCenter1.triagePatient("Carl", 6);
        Assertions.assertEquals("Carl", communityCenter1.nurseQueue.get(0));
    }
    @Test
    public void triagePatientFIFOCase() {
        communityCenter2.triagePatient("Bob", 2);
        communityCenter2.triagePatient("Carl", 6);
        Assertions.assertEquals("Bob", communityCenter2.nurseQueue.get(0));
        Assertions.assertEquals("Carl", communityCenter2.nurseQueue.get(1));
    }
    // Fin step 4 +21 lignes pour le nouveau ficher.
    // Il y a 10 tests à la classe Clinic, il y a une dizaine de comportement également (environ)
    // Le nombre de test != le nombre de comportement, il faut parfois plus d'un test pour un comportement.
    @Test
    public void triagePatientAbusSystem(){
        communityCenter2.triagePatient("PATRICK", 1);
        communityCenter2.triagePatient("SQUIDWARD", 5);
        Assertions.assertEquals("SQUIDWARD", communityCenter2.nurseQueue.getFirst());
    }
    // fin étape 5, ajout d'un test par classe et de 3 lignes par classe en code de production
}