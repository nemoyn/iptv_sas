package com.hgys.iptv.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountSettlement is a Querydsl query type for AccountSettlement
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccountSettlement extends EntityPathBase<AccountSettlement> {

    private static final long serialVersionUID = 754110164L;

    public static final QAccountSettlement accountSettlement = new QAccountSettlement("accountSettlement");

    public final StringPath code = createString("code");

    public final StringPath col1 = createString("col1");

    public final StringPath col2 = createString("col2");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.sql.Timestamp> inputTime = createDateTime("inputTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> isdelete = createNumber("isdelete", Integer.class);

    public final DateTimePath<java.sql.Timestamp> modifyTime = createDateTime("modifyTime", java.sql.Timestamp.class);

    public final StringPath name = createString("name");

    public final StringPath remakes = createString("remakes");

    public final StringPath set_ruleCode = createString("set_ruleCode");

    public final NumberPath<Integer> set_ruleId = createNumber("set_ruleId", Integer.class);

    public final StringPath set_ruleName = createString("set_ruleName");

    public final NumberPath<Integer> set_type = createNumber("set_type", Integer.class);

    public final DateTimePath<java.sql.Timestamp> setEndTime = createDateTime("setEndTime", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> setStartTime = createDateTime("setStartTime", java.sql.Timestamp.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<java.math.BigDecimal> total_sum = createNumber("total_sum", java.math.BigDecimal.class);

    public QAccountSettlement(String variable) {
        super(AccountSettlement.class, forVariable(variable));
    }

    public QAccountSettlement(Path<? extends AccountSettlement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountSettlement(PathMetadata metadata) {
        super(AccountSettlement.class, metadata);
    }

}

