package challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		Long qtd = repository.count();
		int idx = (int)(Math.random() * qtd);
		
		return repository.findById(idx).orElse(null);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotesByActor = repository.findByActor(actor);
		
		int qtd = quotesByActor.size();
		int idx = (int)(Math.random() * qtd);
		
		return quotesByActor.get(idx);
	}

}

