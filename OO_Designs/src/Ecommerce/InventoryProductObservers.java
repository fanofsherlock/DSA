package Ecommerce;

public interface InventoryProductObservers {

	void notificationToRemoveProduct(InventoryProduct product);

	void notificationToAddProduct(InventoryProduct product);

}
