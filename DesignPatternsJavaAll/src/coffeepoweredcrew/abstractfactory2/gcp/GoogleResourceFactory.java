package coffeepoweredcrew.abstractfactory2.gcp;

import coffeepoweredcrew.abstractfactory2.Instance;
import coffeepoweredcrew.abstractfactory2.Instance.Capacity;
import coffeepoweredcrew.abstractfactory2.ResourceFactory;
import coffeepoweredcrew.abstractfactory2.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance(capacity);
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}
	

}
