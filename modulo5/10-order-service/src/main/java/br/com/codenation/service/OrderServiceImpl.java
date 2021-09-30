package br.com.codenation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.codenation.data.ProductsMockedData;
import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		Double totalValue = items.stream()
			.map(item -> {
				Double itemValue = productRepository.findById(item.getProductId()).get().getValue() * item.getQuantity();
				Boolean itemIsSale = productRepository.findById(item.getProductId()).get().getIsSale();
				
				if(itemIsSale == true) {
					itemValue = itemValue - (itemValue * 0.20);
				}
				
				return itemValue;
			})
			.mapToDouble(f -> f.doubleValue())
			.sum();
		
		return totalValue;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
			.map(id -> productRepository.findById(id).get()).collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Double allOrdersValue = 0.0;
		
		for(List<OrderItem> order : orders) {
			Double orderValue = this.calculateOrderValue(order);
			
			allOrdersValue += orderValue;
		}
		
		return allOrdersValue;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		// 1 criar uma lista de produtos
		List<Product> productList = productIds.stream()
				.map(product -> productRepository.findById(product).get())
				.collect(Collectors.toList());
		
		// jogar em um Map
		Map<Boolean, List<Product>> myMap = new HashMap<>();
		
		// fazer a lista de true e de false
		List<Product> listTrue = productList.stream()
				.filter(product -> product.getIsSale() == true)
				.collect(Collectors.toList());
		List<Product> listFalse = productList.stream()
				.filter(product -> product.getIsSale() == false)
				.collect(Collectors.toList());
		
		// adicionar no map
		myMap.put(true, listTrue);
		myMap.put(false, listFalse);
		
		return myMap;
	}

}
