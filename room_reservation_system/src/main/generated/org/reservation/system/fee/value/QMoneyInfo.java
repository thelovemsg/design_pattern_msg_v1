package org.reservation.system.fee.value;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoneyInfo is a Querydsl query type for MoneyInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMoneyInfo extends BeanPath<MoneyInfo> {

    private static final long serialVersionUID = 204026422L;

    public static final QMoneyInfo moneyInfo = new QMoneyInfo("moneyInfo");

    public final NumberPath<java.math.BigDecimal> addedAmount = createNumber("addedAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> discountAmount = createNumber("discountAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> productAmount = createNumber("productAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> salesAmount = createNumber("salesAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> taxAmount = createNumber("taxAmount", java.math.BigDecimal.class);

    public QMoneyInfo(String variable) {
        super(MoneyInfo.class, forVariable(variable));
    }

    public QMoneyInfo(Path<? extends MoneyInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoneyInfo(PathMetadata metadata) {
        super(MoneyInfo.class, metadata);
    }

}

