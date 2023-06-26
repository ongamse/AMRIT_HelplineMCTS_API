package com.iemr.mcts.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper
{
	static GsonBuilder builder;
	static GsonBuilder builderWithoutExposeRestriction;

	public OutputMapper()
	{
		if (builder == null)
		{
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			// LongSerializationPolicy policy = LongSerializationPolicy.STRING;
			builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.serializeNulls();
		}
		if (builderWithoutExposeRestriction == null)
		{
			builderWithoutExposeRestriction = new GsonBuilder();
			builderWithoutExposeRestriction.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builderWithoutExposeRestriction.setLongSerializationPolicy(LongSerializationPolicy.STRING);
		}
	}

	public static Gson gson()
	{
		return builder.create();
	}

	public static Gson gsonWithoutExposeRestriction()
	{
		return builderWithoutExposeRestriction.create();
	}
}