package com.lab9.SpringBoot.dal.repository;

import com.lab9.SpringBoot.dal.model.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMongoRepository extends MongoRepository<PostModel,String> {

}
