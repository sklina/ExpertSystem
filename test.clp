(deftemplate engine (slot state))

(deftemplate recom (slot value (type STRING)))
(deftemplate question (slot text (type STRING))(slot value (default null)))
;(assert (engine (state start)))
;(assert (question (text "Does the engine run normally")(value Yes)))
;

(defrule determine-engine-state ""
(question (text "Does the engine run normally?")(value ?val))
(engine (state start))
(not (repair ?) )
=>
(if (eq ?val Yes)
then
(assert (working-state engine normal) )
else
(if (eq ?val No)
then
(assert (working-state engine unsatisfactory) )))
)


(defrule determine-rotation-state ""
(question (text "Does the engine rotate?")(value ?val))
(working-state engine does-not-start)
(not (rotation-state engine ?))
(not (repair ?))
=>
(printout t "********************************************" crlf)
(if (eq ?val Yes)
then
(assert (rotation-state engine rotates))
(assert (spark-state engine irregular-spark))
else
(if (eq ?val No)
then
(assert (rotation-state engine does-not-rotate))
(assert (spark-state engine does-not-spark))))
)



(defrule determine-gas-level ""
(question (text "Does the tank have any gas in it?")(value ?val))
(working-state engine does-not-start)
(rotation-state engine rotates)
(not (repair ?) )
=>
(if (eq ?val No)
then
(assert (recom (value "Add g a s . ")))
(assert (repair "Add g a s . " ) ) )
)


(defrule determine-battery-state ""
(question (text "Is the battery charged?")(value ?val))
(rotation-state engine does-not-rotate)
(not (charge-state battery ? ) )
(not (repair ?))
=>
(if (eq ?val Yes)
then
(assert (charge-state battery charged))
else
(if (eq ?val No)
then
(assert (recom (value "Charge the battery.")))
(assert (charge-state battery dead)))
(assert (repair "Charge the battery.")))

)
;(assert )

(defrule determine-low-output ""
(question (text "Is the output of the engine low?")(value ?val))
(working-state engine unsatisfactory)
(not (symptom engine low-output | not-low-output))
(not (repair ?))
=>
(if (eq ?val Yes)
then
(assert (symptom engine low-output))
else (if (eq ?val No)
then
(assert (symptom engine not-low-output))))
)

(defrule determine-point-surface-state ""
(question (text "What is the surface state of the points?")(value ?val))
(or (and (working-state engine does-not-start)
(spark-state engine irregular-spark))
(symptom engine low-output))
(not (repair ?))
=>

(if (eq ?val burned)
then
(assert (recom (value "Replace the points.")))
(assert (repair "Replace the points."))
else 
(if (eq ?val contaminated)
then
(assert (recom (value "Clean the points.")))
(assert (repair "Clean the points."))))
)


(defrule determine-conductivity-test ""
(question (text "Is the conductivity test for the ignition coil positive?")(value ?val))
(working-state engine does-not-start)
(spark-state engine does-not-spark)
(charge-state battery charged)
(not (repair ?) )
=>
(if (eq ?val Yes)
then
(assert (recom (value "Repair the distributor lead wire.")))
(assert (repair "Repair the distributor lead wire."))
else (if (eq ?val No)
then
(assert (recom (value "Replace the ignition coil.")))
(assert (repair "Replace the ignition coil."))))
)

(defrule determine-sluggishness ""
(question (text "Is the engine sluggish?")(value ?val))
(working-state engine unsatisfactory)
(not (repair ?))
=>
(if (eq ?val Yes)
then
(assert (recom (value "Clean the fuel line.")))
(assert (repair "Clean the fuel line.")))
)

(defrule determine-misfiring ""
(question (text "Does the engine misfire?")(value ?val))
(working-state engine unsatisfactory)
(not (repair ?))
=>
(if (eq ?val Yes)
then
(assert (recom (value "Point gap adjustment.")))

(assert (spark-state engine irregular-spark)))
(assert (repair "Point gap adjustment."))
)


(defrule determine-knocking ""
(question (text "Does the engine knock?")(value ?val))
(working-state engine unsatisfactory)
(not (repair ?))
=>
(if (eq ?val Yes)
then
(assert (recom (value "Timing adjustment.")))
(assert (repair "Timing adjustment.")))
)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



; добавл€ть вручную

(defrule normal-engine-state-conclusions ""
(declare (salience 10))
(working-state engine normal)
=>
(assert (recom (value "No repair needed.")))

(assert (spark-state engine normal))
(assert (charge-state battery charged))
(assert (rotation-state engine rotates))
(assert (repair "No repair needed."))
)

(defrule unsatisfactory-engine-state-conclusions ""
(declare (salience 10))
(working-state engine unsatisfactory)
=>
(assert (charge-state battery charged))
(assert (rotation-state engine rotates))
)

(defrule no-repairs ""
(declare (salience -10))
(not (repair ?))
=>
(printout t  "Take your car to a mechanic." crlf)
(assert (recom (value "Take your car to a mechanic.")))
(assert (repair "Take your car to a mechanic."))
)

(defrule print-repair ""
(declare (salience 10))
(repair ?item)
=>
(printout t crlf crlf)
(printout t "Suggested Repair:")
(printout t crlf crlf)
(format t " %s%n%n%n" ?item)
)

(defrule system-banner "ѕри каждом новом запуске."
(declare (salience 10) )
=>
(printout t crlf crlf)
(printout t "********************************************" crlf)
(printout t "* The Engine Diagnosis Expert System *" crlf)
(printout t "**********************************" crlf)
(printout t crlf crlf)
)