package com.elasticsearchbulkoperation.client;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class ESTransportClient implements ESClient {

	private TransportClient client;
	private static final String HOST_NAME = "localhost";
	private static final int PORT = 9300;

	@Override
	public Client getClient() {
		if (client == null) {
		InetSocketAddress address = new InetSocketAddress(HOST_NAME, PORT);
			Settings settings = Settings.settingsBuilder().put("node.name", "stackoverflownode").put("cluster.name","stackoverflowcluster").build();
			client = TransportClient.builder().settings(settings).build();
			client.addTransportAddress(new InetSocketTransportAddress(address));

		}
		return client;
	}

	@Override
	public void shutdown() {
		client.close();
		client = null;
	}

}
