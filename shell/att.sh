#! /bin/tcsh

@ Per = `df | grep sda1 | awk '{ print $5 }' | cut -d '%' -f1`
echo -n "Enter a number: "
set Number = "$<"
if ($Number < 0) then
    echo "Enter a real number!"
else
    if ($Number > $Per) then
        echo "yes"
    else
        echo "no"
    endif
endif
