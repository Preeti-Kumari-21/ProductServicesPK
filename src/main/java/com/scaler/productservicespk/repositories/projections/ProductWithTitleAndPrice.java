package com.scaler.productservicespk.repositories.projections;

import com.fasterxml.jackson.databind.node.DoubleNode;

public interface ProductWithTitleAndPrice {
    String getTitle();

    Double getPrice();
}
