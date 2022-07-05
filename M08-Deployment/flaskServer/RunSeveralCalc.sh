export FLASK_APP=calc.py
export FLASK_RUN_PORT=5000
flask run &
export FLASK_RUN_PORT=5001
flask run &
export FLASK_RUN_PORT=5002
flask run &
export FLASK_RUN_PORT=5003
flask run &
echo $FLASK_APP is running
