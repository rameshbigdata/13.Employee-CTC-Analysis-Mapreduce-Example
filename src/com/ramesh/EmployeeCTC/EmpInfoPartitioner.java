package com.ramesh.ctc;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class EmpInfoPartitioner extends Partitioner <Text, Text>
{
	@Override
	public int getPartition(Text key, Text value, int numReduceTasks)
	{
		int partitionNo = 0;
		String [] tokens = value.toString().split("\\t");
		String gender = tokens[3];

		if(numReduceTasks != 0)
		{
			if(gender.equals("female"))
				partitionNo = 0;
			else
				partitionNo = 1;
		}
		return partitionNo;
	}
}