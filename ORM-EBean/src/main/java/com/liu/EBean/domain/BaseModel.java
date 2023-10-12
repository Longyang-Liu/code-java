package com.liu.EBean.domain;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Version;
import java.time.Instant;

@Data
public abstract class BaseModel extends Model {

    @Id
    long id;

    @Version
    Long version;

    @WhenCreated
    Instant whenCreated;

    @WhenModified
    Instant whenModified;
}
