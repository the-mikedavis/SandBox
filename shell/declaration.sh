#! /bin/bash
#this is to show that tcsh commands don't work in bash
echo "tcsh:"
set VAR1="hi"
echo $VAR1
unset VAR1
echo $VAR1

echo "bash:"
foo="hi"
echo $foo
unset foo
echo $foo

