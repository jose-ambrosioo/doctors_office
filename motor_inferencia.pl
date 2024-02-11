/***********************************************
Ficheiro : Motor de inferencia
Descric��o :

***********************************************/

dyn_facto:- dynamic facto/2.

/*******************************************
Descri��o : A regra prepararCondicoes serve para criar
as condi��es necessarias para iniciar o processo
de inferencia.
*******************************************/
prepararCondicoes :-
	abolish(facto, 2), %Elimina todos os factos dinamicos e tambem a diretriz dyn_facto%
	dyn_facto,         %Escreve no ficheiro a diretriz dyn_facto%
	reconsult('base_conhecimento'). %Compila o ficheiro base_conhecimento.pl e unica com o ficheiro motor_inferencia.pl%


/*******************************************
Descri��o : Regra responsavel por come�ar o
processo de inferencia.
*******************************************/

iniciarProcessoInferencia :-
	encontrarConclusao(av(diagnostico, _)).


/******************************************
Descri��o : Verifica se a informa��o esta em
armazenamento operacional (quadro negro)
*******************************************/
encontrarPremissas(av(Atributo, Valor), CF) :-
	facto(av(Atributo, Valor), CF).


/**********************************************
Descri��o : Esta a regra tem a fun��o de analisar
cada uma das regras na base de conhecimneto que
da suporte a um determinado diagnostico
**********************************************/
encontrarConclusao(Objectivo) :-
	regra(_, lhs(ListaPremissas), rhs(Objectivo, CF)),
	provar(ListaPremissas, CF_Final_Das_Premissas), %Verifica se as premissas s�o validas e e encontra o CF das premissas%
	CF_Conclusao is CF * CF_Final_Das_Premissas / 100, %Calcula o CF final para a conclus�o da regra%
	CF_Conclusao > 0,
	asserta(facto(Objectivo, CF_Conclusao)), %Inseri no armazenamento de trabalho (quadro negro) os os valores da nova conclus�o%
	fail.

/*************************************
Descri��o : Esta regra tem fun��o de
obter o factor de certeza final das premissas
de uma determinada regra.
**************************************/
provar(ListaPremissas, CF_Final_Das_Premissas) :-
	prov(ListaPremissas, 0, CF_Final_Das_Premissas, 0).

/****************************************
Descri��o : Esta regra cobre o caso de que
n�o h� mais premissas para analisar ent�o
o facto de certeza final da premissas �
calculado pela divis�o entre somatorio do
CF das premissas dividindo pelo numero
total de premissas
****************************************/
prov([], Somatorio_CF_Premissas, CF_Final_Das_Premissas, NumTotalPremissas):-
	CF_Final_Das_Premissas is Somatorio_CF_Premissas / NumTotalPremissas.


/******************************************
Descri��o : Esta regra cobre o caso de que
h� mais premissas para analisar
*******************************************/
prov([H | T], Somatorio_CF_Premissas, CF_Final_Das_Premissas, NumTotalPremissas) :-
	encontrarPremissas(H, CF), /*Pega a premissa que esta na cabe�a da lista e verifica se � valida*/
	soma(Somatorio_CF_Premissas_Temporario, CF, Somatorio_CF_Premissas), /*Faz a soma entre o CF da premissa que esta na cabe�a da lista com o resultado do somatorio das premissas anteriores*/
	Resultado is NumTotalPremissas + 1,/*Faz o incremento de uma unidade para saber o numero total de premissas de uma determinada regra*/
    prov(T, Somatorio_CF_Premissas_Temporario, CF_Final_Das_Premissas, Resultado).


/*******************************************
Descri��o : Esta regra � chamada quando
estiver a fazer o processo de inferencia
da primeira premissa de cada regra, isto
quer dizer que ainda n�o foi feito nenhum
somatorio usando os CF da premissas ent�o
define que o CF da primeira premissa � o
CF final das premissas.
*******************************************/
soma(CF, CF, 0):- !.

/*******************************************
Descri��o : Faz a soma entre o CF da premissa
actual com o resultado do somatorio de todas
as premissas anteriores
*******************************************/
soma(Somatorio_CF_Premissas_Temporario, CF, Somatorio_CF_Premissas):-
	Somatorio_CF_Premissas_Temporario is CF + Somatorio_CF_Premissas.


inserir_facto(Regra) :-
    open('base_conhecimento.pl',append,Stream),
         write(Stream,Regra),  nl(Stream),
         close(Stream).








































