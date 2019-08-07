#!/bin/bash

echo "1) Personal"
echo "	ceezuns@gmail.com, 305E279D82819B20"

echo ""

echo "2) GitHub Provided"
echo "	49824660+ceezuns@users.noreply.github.com, 15C9630ACADE5855"

echo ""

echo "Choose A Profile: "

read profile

if [ $profile == "1" ]; then
	git config user.email "ceezuns@gmail.com"
	git config user.signingkey "305E279D82819B20"
elif [ $profile == "2" ]; then
	git config user.email "49824660+ceezuns@users.noreply.github.com"
	git config user.signingkey "15C9630ACADE5855"
else
	echo "An Error Occurred, Please Relaunch The Script"
fi
