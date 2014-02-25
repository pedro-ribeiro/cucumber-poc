package com.byclosure;

//import at.porscheinformatik.cucumber.formatter.MongoDbFormatter;

import java.io.File;

/**
 *
 */
public class MongoDBFormatter
//        extends MongoDbFormatter
{

    public MongoDBFormatter(File htmlReportDir) {
//        super(htmlReportDir);
    }

//    @Override
    protected String getHost() {
        return "localhost";
    }

//    @Override
    protected int getPort() {
        return 27017;
    }

//    @Override
    protected String getDbName() {
        return "test";
    }

//    @Override
    protected String getCollection() {
        return "testCollection";
    }
}
