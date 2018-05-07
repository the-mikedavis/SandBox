member(Element, [Element | _]).
member(Element, [_ | List]) :- member(Element, List).
