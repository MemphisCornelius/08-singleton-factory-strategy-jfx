package ohm.softa.a08.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenMensaAPIService {

	private static OpenMensaAPIService instance;
	private OpenMensaAPI mensaAPIInstance;
	private OpenMensaAPIService() {
		var interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		/* create a OkHttpClient and register the interceptor */
		var client = new OkHttpClient.Builder()
			.addInterceptor(interceptor)
			.build();


		var retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create(new Gson()))
			.baseUrl("http://openmensa.org/api/v2/")
			.client(client)
			.build();

		/* create OpenMensaAPI instance */
		mensaAPIInstance = retrofit.create(OpenMensaAPI.class);
	}

	public static OpenMensaAPIService getInstance() {
		if (instance == null) {
			instance = new OpenMensaAPIService();
		}
		return instance;
	}

	public OpenMensaAPI getAPI() {
		return mensaAPIInstance;
	}
}
