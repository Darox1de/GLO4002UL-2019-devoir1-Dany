package Classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.engine.*;
import java.util.LinkedList;

public class ClinicTest {

    public Clinic clinicRadioFifo = new RadioQueueFifo();
    public Clinic clinicRadioGravity = new RadioQueueGravity();
    public Clinic clinicDoctorFifo = new DoctorQueueFifo();
    public Clinic clinicDoctorGravity = new DoctorQueueGravity();

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheDoctorWaitingList() {
        clinicDoctorFifo.triagePatient("Patrick", 5, VisibleSymptom.BROKEN_BONE);
        clinicDoctorGravity.triagePatient("Bob", 5, VisibleSymptom.BROKEN_BONE);
        Assertions.assertEquals("Patrick", clinicDoctorFifo.doctorQueue.get(0));
        Assertions.assertEquals("Bob", clinicDoctorGravity.doctorQueue.get(0));
    }

    @Test
    public void whenTriagingPatientWithTheFlu_thenPatientIsNotAddedToTheRadiologyWaitingList() {
        clinicRadioFifo.triagePatient("Squidward", 10, VisibleSymptom.FLU);
        clinicRadioGravity.triagePatient("Sandy", 10, VisibleSymptom.FLU);
        Assertions.assertEquals(0, clinicRadioFifo.radioQueue.size());
        Assertions.assertEquals(0, clinicRadioGravity.radioQueue.size());
    }

    @Test
    public void whenTriagingPatientWithABrokenBone_thenPatientIsAddedToTheRadiologyWaitingList() {
        clinicRadioFifo.triagePatient("Patrick", 10, VisibleSymptom.BROKEN_BONE);
        clinicRadioGravity.triagePatient("Bob", 10, VisibleSymptom.BROKEN_BONE);
        Assertions.assertEquals("Patrick", clinicRadioFifo.radioQueue.get(0));
        Assertions.assertEquals("Bob", clinicRadioGravity.radioQueue.get(0));
    }

    @Test
    public void whenTriagingPatientWithASprain_thenPatientIsAddedToTheRadiologyWaitingList() {
        clinicRadioFifo.triagePatient("Patrick", 10, VisibleSymptom.SPRAIN);
        clinicRadioGravity.triagePatient("Bob", 10, VisibleSymptom.SPRAIN);
        Assertions.assertEquals("Patrick", clinicRadioFifo.radioQueue.get(0));
        Assertions.assertEquals("Bob", clinicRadioGravity.radioQueue.get(0));
    }
}
