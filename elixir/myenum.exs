defmodule MyEnum do


  def all?([], _predicate), do: true # vacuous truth

  def all?([ head | tail ], predicate) do
    predicate.(head) && all?(tail, predicate)
  end


  def each([], _fcn), do: :ok

  def each([ head | tail ], fcn) do
    fcn.(head)
    each(tail, fcn)
  end


  def filter([], _predicate), do: []

  def filter([ head | tail ], predicate) do
    if predicate.(head) do
      [ head | filter(tail, predicate) ]
    else
      filter(tail, predicate)
    end
  end


  def split([], _count), do: {[], []}
  # the negative param option looks hard
  def split(list, 0) do 
    {[], list}
  end

  def split([ head | tail ], count) do
    {f, b} = split(tail, count - 1)
    {[ head | f ], b}
  end


  def take([], _), do: []
  #again, the negative index thing looks hand
  def take(list, 0) when is_list(list), do: []

  def take([ head | tail ], count), do: [head | take(tail, count - 1)]


  def flatten([]), do: []

  def flatten([ head | tail ]) when is_list(head) do
    flatten(head ++ tail)
  end

  def flatten([ head | tail ]) do
    [ head | flatten(tail) ]
  end


  def primes(n) do
  end
end
