package com.karzhen.numeration;

import java.util.Date;

/**
 * Created by Yusuf on 12/11/2017.
 */

public class NumeratorPost
{
    public int id;
    public String ActivitiyName;
    public String CategoryName;
    public String CountingType;
    public int ProgressNumber;
    public Date ProgressDate;

    public NumeratorPost(int id, String activityName, String categoryName, String countingType, int progressNumber, Date progressDate)
    {
        this.id = id;
        ActivitiyName = activityName;
        CategoryName = categoryName;
        CountingType = countingType;
        ProgressNumber = progressNumber;
        ProgressDate = progressDate;
    }

}
