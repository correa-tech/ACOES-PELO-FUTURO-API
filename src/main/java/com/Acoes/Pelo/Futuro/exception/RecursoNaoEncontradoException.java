package com.Acoes.Pelo.Futuro.exception;

public class RecursoNaoEncontradoException  extends RuntimeException{

    public RecursoNaoEncontradoException (String mensagem){
        super(mensagem);
    }

    public RecursoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
