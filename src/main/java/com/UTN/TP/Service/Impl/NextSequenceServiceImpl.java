package com.UTN.TP.Service.Impl;

import com.UTN.TP.Entity.CustomSequence;
import com.UTN.TP.Service.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service("NextSequenceServiceImpl")
public class NextSequenceServiceImpl implements NextSequenceService {

    @Autowired
    private MongoOperations mongo;

    @Override
    public int getNextSequenceAdmin(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqAdmin",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqAdmin();

    }

    @Override
    public int getNextSequenceDoctor(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqDoctor",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqDoctor();

    }

    @Override
    public int getNextSequencePatient(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqPatient",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqPatient();

    }

    @Override
    public int getNextSequenceAction(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqAction",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqAction();

    }

    @Override
    public int getNextSequenceDisease(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqDisease",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqDisease();

    }

    @Override
    public int getNextSequenceTreatment(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqTreatment",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqTreatment();

    }


    public int getNextSequencePerson(String seqName) {

        CustomSequence counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seqPerson",1),
                options().returnNew(true).upsert(true),
                CustomSequence.class);
        return counter.getSeqPerson();

    }
}
