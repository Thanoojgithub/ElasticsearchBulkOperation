package com.elasticsearchbulkoperation.client;

import org.elasticsearch.client.Client;

public interface ESClient {

	/**
	 * Get a reference to an ElasticSearch
	 */
	Client getClient();

	/**
	 * Shutdown the ElasticSearch
	 */
	void shutdown();
}
