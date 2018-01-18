fb = fn
  0, 0, _    -> "FizzBuzz"
  0, _, _    -> "Fizz"
  _, 0, _    -> "Buzz"
  _, _, last -> last
end

no_cond = fn
  n -> fb.(rem(n, 3), rem(n, 5), n)
end

IO.puts no_cond.(10)
IO.puts no_cond.(11)
IO.puts no_cond.(12)
IO.puts no_cond.(13)
IO.puts no_cond.(14)
IO.puts no_cond.(15)
IO.puts no_cond.(16)
