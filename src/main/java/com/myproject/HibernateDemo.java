package com.myproject;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "AppointmentTable")
public class HibernateDemo implements Serializable {
	private static final long serialVersionUID = 1L;

    @GenericGenerator(name = "generator", strategy = "increment")

    @GeneratedValue(generator = "generator")
    @Column(name = "appointmentID")
    @Id
    private int appointmentID;
    @Column(name = "doctor_no")
    private String doctorNo;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "patient_no")
    private String patientNo;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "operation_no")
    private String operationNo;

    public int getAppointmentID() {
        return appointmentID;
        
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

}