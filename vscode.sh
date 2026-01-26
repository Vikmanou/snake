os=linux
if [ "$(which cygpath)" != "" ]; then
    os=cygwin
fi

chemin_settings=~/AppData/Roaming/Code/User/settings.json

if [ $os = "linux" ]; then
    chemin_settings=~/.config/Code/User/settings.json
fi

echo ""
echo -n "écriture de $chemin_settings ..."

code --install-extension redhat.java@1.50.0 1>/dev/null

redhat_home=$(find ~/.vscode/extensions/ -name "redhat.java-1.50.0*")
jre_home=$(find $redhat_home/jre -name "21*")
jre_home_win=$jre_home

if [ "$os" = "cygwin" ]; then
    jre_home_win=$(cygpath -w $jre_home)
fi

export JAVA_HOME=$jre_home

echo {\"java.jdt.ls.java.home\":\"$jre_home_win\"} | sed "s%\\\\%\\\\\\\\%g" > $chemin_settings

echo " fait"
echo ""


