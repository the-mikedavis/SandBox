defmodule DP do

  #defmacro left |> right do
    #[{h, _} | t] = Macro.unpipe({:|>, [], [left, right]})
    #end
    
  defmacro sec(fun, first) do
    #quote do: (&unquote(fun).(unquote(first), &1))
    quote do
      fn x -> unquote(fun).(unquote(first), x) end
    end
  end


  def s(fun, first) do
    quote do: (&unquote(fun).(unquote(first), &1)).()
  end

end
