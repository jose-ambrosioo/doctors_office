/***********************************************
Ficheiro : Base de conhecimento
Descricção :

***********************************************/

:- discontiguous pergunta/4.
:- discontiguous regra/3.


pergunta(sintoma, temperatura_alta, 'Estas com temperatura altas ?', "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, tremor, "Tens tremor ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, dor_de_cabeca, "Estas com dor de cabeca ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, vomitos, 'Esta a vomitar?', "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, fadiga, "Estas com fadiga ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, suor, "Estas a suar?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, tosse, 'Estas a tossir ?', "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, colicas, "Estas com colica ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, feridas_na_pele, "Estas com ferida na pele ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, tontura, "Estas com tontura ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, dor_abdominal, "Estas com dor de abdominal ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
pergunta(sintoma, falta_de_apetite, "Estas com falta de apetite ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").


regra(1,
      lhs([av(sintoma, temperatura_alta), av(sintoma, tremor), av(sintoma, dor_de_cabeca), av(sintoma, vomitos), av(sintoma, fadiga), av(sintoma, suor)]),
      rhs(av(diagnostico, malaria), 100)
     ).

regra(2,
      lhs([av(sintoma, temperatura_alta), av(sintoma, tosse), av(sintoma, suor), av(sintoma, dor_de_cabeca), av(sintoma, fadiga), av(sintoma, colicas), av(sintoma, feridas_na_pele)]),
      rhs(av(diagnostico, hiv), 100)
     ).

regra(3,
	  lhs([av(sintoma, colicas), av(sintoma, temperatura_alta), av(sintoma, fadiga), av(sintoma, vomitos), av(sintoma, dor_de_cabeca), av(sintoma, tontura)]),
	  rhs(av(diagnostico,gestacao), 100)
	 ).

regra(4,
	  lhs([av(sintoma, temperatura_alta), av(sintoma, dor_de_cabeca), av(sintoma, dor_abdominal), av(sintoma, tosse), av(sintoma, colicas), av(sintoma, falta_de_apetite)]),
	   rhs(av(diagnostico,febre_tifoide), 100)
	).


pergunta(sintoma, fraqueza, "Tens fraqueza ?", "Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao").
