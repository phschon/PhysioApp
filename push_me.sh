echo "Checking physio-xsuaa service instance..."
if ! cf s | grep -q physio-xsuaa;
then
	cf create-service xsuaa application physio-xsuaa -c xs-security.json
else
	cf update-service physio-xsuaa -c xs-security.json
fi
echo "Creating backend application"
cd CF_ApplicationBackEnd/ &&
mvn clean install -DskipTests && 
cd - &&
cf push -f CF_ApplicationBackEnd/
echo "Creating frontend application"
cd physioapp &&
rm package-lock.json &&
npm install &&
cf push
cd -
