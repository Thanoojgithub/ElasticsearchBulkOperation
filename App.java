package com.elasticsearchbulkoperation.app;

import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.elasticsearchbulkoperation.client.ESTransportClient;
import com.elasticsearchbulkoperation.type.Movie;
import com.google.gson.Gson;

public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	private static final ESTransportClient eSTransportClient = new ESTransportClient();
	private static final String INDEX = "movies_1.0.0";
	private static final String TYPE = "movie";

	public static void main(String[] args) {
		indexAndDocument();
	}

	private static void indexAndDocument() {
		Client client = eSTransportClient.getClient();
		BulkRequestBuilder prepareBulk = client.prepareBulk();
		BulkRequestBuilder bulkRequestBuilder = null;
		Gson gson = new Gson();
		int im = 1;
		for (Movie m : MoviesJSON.getMoviesListFromJSON(MoviesJSON.getMoviesJSON())) {
			bulkRequestBuilder = prepareBulk.add(client.prepareIndex(INDEX, TYPE, String.valueOf((im++))).setSource(gson.toJson(m)));
		}
		BulkResponse actionGet = bulkRequestBuilder.execute().actionGet();
		LOG.info("movies document has been indexed.");
		
		for (BulkItemResponse bulkItemResponse : actionGet.getItems()) {
			System.out.println("App.indexAndDocument() :: " + bulkItemResponse.getId() + " "
					+ bulkItemResponse.getIndex() + " " + bulkItemResponse.getItemId() + " "
					+ bulkItemResponse.getType() + " " + bulkItemResponse.getResponse());
		}
		// eSTransportClient.shutdown();
	}

	
}
