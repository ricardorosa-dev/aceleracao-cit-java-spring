package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
;


public class DesafioMeuTimeApplication implements MeuTimeInterface{
    private ArrayList<Time> times = new ArrayList<>();
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public Time buscarTimePorId(Long idTime) {
    	Time meuTime = null;
    	for (Time time : times) {
    		if (time.id == idTime) {
    			meuTime = time;
			}
		}
    	return meuTime;
	}

	public Jogador buscarJogadorPorId(Long idJogador) {
		Jogador meuJogador = null;
		for (Jogador jogador : jogadores) {
			if (jogador.id == idJogador) {
				meuJogador = jogador;
			}
		}
		return meuJogador;
	}

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (buscarTimePorId(id) == null) {
			times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		} else {
			throw new IdentificadorUtilizadoException("Esse time já existe!");
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (buscarTimePorId(idTime) == null) {
			throw new TimeNaoEncontradoException("Este id de time não existe!");
		}

    	if (buscarJogadorPorId(id) == null) {
    		Jogador meuJogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
			jogadores.add(meuJogador);
		} else {
			throw new IdentificadorUtilizadoException("Este jogador já existe!");
		}
	}

	public void definirCapitao(Long idJogador) {
		Jogador meuJogador = buscarJogadorPorId(idJogador);

		if (meuJogador != null) {
			meuJogador.capitao = true;
		} else {
			throw new JogadorNaoEncontradoException("Esse jogador não existe!");
		}
	}

	public Long buscarCapitaoDoTime(Long idTime) {
		Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			Long meuJogador = null;

			for (Jogador jogador : jogadores) {
				if (jogador.capitao == true) {
					meuJogador = jogador.id;
				}
			}
			if (meuJogador != null) {
				return meuJogador;
			} else {
				throw new CapitaoNaoInformadoException("Esse time não tem capitão!");
			}
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe");
		}
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador meuJogador = buscarJogadorPorId(idJogador);

		if (meuJogador != null) {
			return meuJogador.nome;
		} else {
			throw new JogadorNaoEncontradoException("Esse jogador não existe!");
		}
	}

	public String buscarNomeTime(Long idTime) {
		Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			return meuTime.nome;
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe!");
		}
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			List<Long> jogadoresTime = new ArrayList<>();

			for (Jogador jogador : jogadores) {
				jogadoresTime.add(jogador.id);
			}
			return jogadoresTime;
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe");
		}
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			Integer maiorNivelHabilidade = 0;
			Long idMelhorJogador = null;
			for (Jogador jogador : jogadores) {
				if (jogador.nivelHabilidade > maiorNivelHabilidade) {
					maiorNivelHabilidade = jogador.nivelHabilidade;
					idMelhorJogador = jogador.id;
				}
			}
			return idMelhorJogador;
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe!");
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
    	Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			LocalDate dataMaisVelha = LocalDate.now();
			Long idJogadorMaisVelho = null;
			for (Jogador jogador : jogadores) {
				if (jogador.dataNascimento.isBefore(dataMaisVelha)) {
					dataMaisVelha = jogador.dataNascimento;
					idJogadorMaisVelho = jogador.id;
				}
			}
			return idJogadorMaisVelho;
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe!");
		}

	}

	public List<Long> buscarTimes() {
		ArrayList<Long> listaIdTimes = new ArrayList<>();
		for (Time time : times) {
			listaIdTimes.add(time.id);
		}

		return listaIdTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time meuTime = buscarTimePorId(idTime);

		if (meuTime != null) {
			BigDecimal maiorSalario = new BigDecimal("0.0");
			Long meuJogadorId = null;

			for (Jogador jogador : jogadores) {
				if (jogador.salario.compareTo(maiorSalario) > 0) {
					maiorSalario = jogador.salario;
					meuJogadorId = jogador.id;
				}
			}
			return meuJogadorId;
		} else {
			throw new TimeNaoEncontradoException("Esse time não existe!");
		}
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador meuJogador = buscarJogadorPorId(idJogador);

		if (meuJogador != null) {
			return meuJogador.salario;
		} else {
			throw new JogadorNaoEncontradoException("Esse jogador não existe!");
		}
	}

	public List<Long> buscarTopJogadores(Integer top) {
		jogadores.sort(Comparator.comparing(Jogador::getNivelHabilidade).reversed());
		for (Jogador jogador : jogadores) {
			System.out.println(jogador.id);
		}
		List<Long> idTopJogadores = new ArrayList<>();

		for (Jogador jogador : jogadores) {
			idTopJogadores.add(jogador.id);
		}
		if (idTopJogadores.size() > 0) {
			return idTopJogadores.subList(0, top);
		} else {
			return Collections.emptyList();
		}
	}

}
