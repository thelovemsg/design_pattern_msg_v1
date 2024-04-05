package org.reservation.system.fee.value;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMoney is a Querydsl query type for Money
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QMoney extends BeanPath<MoneyInfo> {

    private static final long serialVersionUID = -1631892120L;

    public static final QMoney money = new QMoney("money");

    public final NumberPath<java.math.BigDecimal> discountAmount = createNumber("discountAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> productAmount = createNumber("productAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> salesAmount = createNumber("salesAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> taxAmount = createNumber("taxAmount", java.math.BigDecimal.class);

    public QMoney(String variable) {
        super(MoneyInfo.class, forVariable(variable));
    }

    public QMoney(Path<? extends MoneyInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMoney(PathMetadata metadata) {
        super(MoneyInfo.class, metadata);
    }

}

