package com.UTN.TP.Service;

public interface NextSequenceService {
    public int getNextSequenceAdmin(String seqName);
    public int getNextSequenceDoctor(String seqName);
    public int getNextSequencePatient(String seqName);
    public int getNextSequenceDisease(String seqName);
    public int getNextSequenceTreatment(String seqName);
    public int getNextSequencePerson(String seqName);
    public int getNextSequenceAction(String seqName);

}
