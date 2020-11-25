package com.spodaryk.views;

import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException;
}
