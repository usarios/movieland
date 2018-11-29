package com.dmuzychuk.movieland.entity.common;

import java.beans.PropertyEditorSupport;

public class SortingColumnConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(SortingColumn.getByName(text));
    }
}
