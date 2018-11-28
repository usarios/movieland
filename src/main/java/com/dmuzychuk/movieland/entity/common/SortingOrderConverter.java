package com.dmuzychuk.movieland.entity.common;

import java.beans.PropertyEditorSupport;

public class SortingOrderConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(SortingOrder.getByName(text));
    }
}
