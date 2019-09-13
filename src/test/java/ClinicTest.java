package Classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.engine.*;
import java.util.*;

public class ClinicTest {
    public Clinic clinic1 = new Clinic(TriageType.FIFO, TriageType.FIFO);
    public Clinic clinic2 = new Clinic(TriageType.FIFO, TriageType.FIFO);
    public Clinic clinic3 = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
    public Clinic clinic4 = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);

    @Test
    public void clinicQueueInstanciation() {
        Assertions.assertEquals(0, clinic1.radioQueue.size());
        Assertions.assertEquals(0, clinic1.doctorQueue.size());
    }
    @Test
    public void clinicQueueTypes() {
        Assertions.assertEquals(TriageType.FIFO, clinic1.doctorListType);
        Assertions.assertEquals(TriageType.FIFO, clinic1.radioListType);
    }
    @Test
    public void triagePatientGravityOver5firstInLine() {
        clinic1.triagePatient("Bob", 1, VisibleSymptom.COLD);
        clinic1.triagePatient("Carl", 6, VisibleSymptom.COLD);
        Assertions.assertEquals("Carl", clinic1.doctorQueue.get(0));
    }
    @Test
    public void triagePatientBrokenBoneCase() {
        clinic1.triagePatient("Bobby", 1, VisibleSymptom.BROKEN_BONE);
        Assertions.assertEquals("Bobby", clinic1.radioQueue.get(0));
    }
    @Test
    public void triagePatientSprainCase() {
        clinic1.triagePatient("Baba", 1, VisibleSymptom.SPRAIN);
        Assertions.assertEquals("Baba", clinic1.radioQueue.get(0));
    }
    @Test
    public void triagePatientSprainGravityOver5Case() {
        clinic2.triagePatient("Homer", 7, VisibleSymptom.SPRAIN);
        Assertions.assertEquals("Homer", clinic2.radioQueue.get(0));
    }
    @Test
    public void triagePatientFluCase() {
        clinic2.triagePatient("Lisa", 8, VisibleSymptom.SPRAIN);
        clinic2.triagePatient("Bart", 1, VisibleSymptom.FLU);
        Assertions.assertEquals("Bart", clinic2.doctorQueue.get(1));
    }
    @Test
    public void triagePatientMigraineCase() {
        clinic2.triagePatient("Marge", 1, VisibleSymptom.MIGRAINE);
        Assertions.assertEquals("Marge", clinic2.doctorQueue.getFirst());
    }
    @Test
    public void triagePatientGravityQueueCase() {
        clinic3.triagePatient("Maggy", 9, VisibleSymptom.BROKEN_BONE);
        clinic3.triagePatient("Moe", 9, VisibleSymptom.BROKEN_BONE);
        Assertions.assertEquals("Moe", clinic3.doctorQueue.getFirst());
        Assertions.assertEquals("Maggy", clinic3.doctorQueue.get(1));
    }
    @Test
    public void triagePatientGravityRadio(){
        clinic4.triagePatient("Maggy", 9, VisibleSymptom.BROKEN_BONE);
        clinic4.triagePatient("Moe", 9, VisibleSymptom.BROKEN_BONE);
        Assertions.assertEquals("Moe", clinic4.radioQueue.getFirst());
        Assertions.assertEquals("Maggy", clinic4.radioQueue.get(1));
    }
    // 5 lignes de modifiées post step 3
}